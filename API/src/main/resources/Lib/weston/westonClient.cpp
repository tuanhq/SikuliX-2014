#include <iostream>
#include <string.h>
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fstream>
#include <sstream>
#include <fcntl.h>
#include <vector>
#include <linux/input.h>

using namespace std;

/* Pre-defined touch lcd driver path */
#define DEV_INPUT_TOUCHLCD "/dev/input/touch"
#define DEBUGMODE 1
#define UINT16 u_int16_t

#define TRUE true
#define FALSE false
#define SLOT_COUNT 5
#define TRACKING_MAX 5

int g_nMode = 2;
int last_slot = 0;
int touch_fd = -1;
int next_tracking_id = 0;

struct mySlot
{
	bool active;
	UINT16 x, y;
};

mySlot MTslots[SLOT_COUNT];

//* SendTouchEvent
int SendTouchEvent(const char *pStrDevName, char *pTouchData)
{
	if (pStrDevName != NULL && pTouchData != NULL)
	{
		if (g_nMode >= DEBUGMODE)
			printf("<AutoTest> Start SendTouchEvent touch fd path = %s\n", pStrDevName);

		int res;
		bool changed;
		input_event id_ev;
		input_event xy_ev[8];
		bool active;
		UINT16 x;
		UINT16 y;

		if (touch_fd < 0)
		{
			touch_fd = open(pStrDevName, O_RDWR | O_NONBLOCK);
			if (touch_fd < 0)
			{
				if (g_nMode >= DEBUGMODE)
					printf("<AutoTest> touch_fd open fail\n");
				return 0;
			}
			else
			{
				if (g_nMode >= DEBUGMODE)
					printf("<AutoTest> touch_fd open success\n");
			}
		}

		for (int i = 0; i < SLOT_COUNT; i++)
		{
			active = (pTouchData[i * 5] == TRUE);
			x = (((unsigned char)pTouchData[(i * 5) + 1] << 8) | (unsigned char)pTouchData[(i * 5) + 2]);
			y = (((unsigned char)pTouchData[(i * 5) + 3] << 8) | (unsigned char)pTouchData[(i * 5) + 4]);

			if (active)
			{
				changed = ((active != MTslots[i].active) || (x != MTslots[i].x) || (y != MTslots[i].y));
			}
			else
			{
				changed = (active != MTslots[i].active);
			}

			if (!changed)
				continue;

			if (last_slot != i)
			{
				id_ev.type = EV_ABS;
				id_ev.code = ABS_MT_SLOT;
				id_ev.value = i;
				if (g_nMode >= DEBUGMODE)
					printf("<AutoTest> EV_ABS ABS_MT_SLOT %d\n", id_ev.value);
				res = write(touch_fd, &id_ev, sizeof(struct input_event));
				if (res < 0)
				{
					printf("<AutoTest> touch_fd write error 01\n");
					return 0;
				}
				last_slot = i;
			}

			if (!active)
			{
				MTslots[i].x = MTslots[i].y = 0xFFFF;
				MTslots[i].active = false;

				xy_ev[0].type = EV_ABS;
				xy_ev[0].code = ABS_MT_TRACKING_ID;
				xy_ev[0].value = -1;

				if (g_nMode >= DEBUGMODE)
					printf("<AutoTest> EV_ABS ABS_MT_TRACKING_ID %d\n", xy_ev[0].value);

				xy_ev[1].type = EV_SYN;
				xy_ev[1].code = SYN_REPORT;
				xy_ev[1].value = 0;

				if (g_nMode >= DEBUGMODE)
					printf("<AutoTest> EV_SYN SYN_REPORT %d\n", xy_ev[1].value);

				res = write(touch_fd, xy_ev, sizeof(struct input_event) * 2);
				if (res < 0)
				{
					printf("<AutoTest> touch_fd write error 02\n");
					return 0;
				}

				continue;
			}

			if (!MTslots[i].active)
			{
				id_ev.type = EV_ABS;
				id_ev.code = ABS_MT_TRACKING_ID;
				if (next_tracking_id > TRACKING_MAX)
					next_tracking_id = 0;
				id_ev.value = next_tracking_id++;

				if (g_nMode >= DEBUGMODE)
					printf("<AutoTest> EV_ABS ABS_MT_TRACKING_ID %d\n", id_ev.value);

				res = write(touch_fd, &id_ev, sizeof(struct input_event));
				if (res < 0)
				{
					printf("<AutoTest> touch_fd write error 03\n");
					return 0;
				}
				MTslots[i].active = true;
			}

			if (active)
			{
				MTslots[i].x = x;
				MTslots[i].y = y;

				xy_ev[0].type = EV_ABS;
				xy_ev[0].code = ABS_MT_POSITION_X;
				xy_ev[0].value = x;

				if (g_nMode >= DEBUGMODE)
					printf("<AutoTest> EV_ABS ABS_MT_POSITION_X %d\n", xy_ev[0].value);

				xy_ev[1].type = EV_ABS;
				xy_ev[1].code = ABS_MT_POSITION_Y;
				xy_ev[1].value = y;

				if (g_nMode >= DEBUGMODE)
					printf("<AutoTest> EV_ABS ABS_MT_POSITION_Y %d\n", xy_ev[1].value);

				xy_ev[2].type = EV_SYN;
				xy_ev[2].code = SYN_REPORT;
				xy_ev[2].value = 0;

				if (g_nMode >= DEBUGMODE)
					printf("<AutoTest> EV_SYN SYN_REPORT %d\n", xy_ev[2].value);

				res = write(touch_fd, xy_ev, sizeof(struct input_event) * 3);
				if (res < 0)
				{
					printf("<AutoTest> touch_fd write error 04\n");
					return 0;
				}
			}
		}

		if (g_nMode >= DEBUGMODE)
			printf("<AutoTest> End SendTouchEvent\n");
	}

	return 0;
}

void mouseDown(int nX, int nY)
{
	cout << "mouseDown at: (" << nX << "," << nY << ")" << endl;
	char arTouchData[5];
	arTouchData[0] = TRUE;
	arTouchData[1] = (nX >> 8) & 0xff;
	arTouchData[2] = (nX)& 0xff;
	arTouchData[3] = (nY >> 8) & 0xff;
	arTouchData[4] = (nY)& 0xff;
	SendTouchEvent(DEV_INPUT_TOUCHLCD, arTouchData);
}

void mouseUp(int nX, int nY)
{
	cout << "mouseUp at: (" << nX << "," << nY << ")" << endl;
	char arTouchData[5];
	arTouchData[0] = FALSE;
	arTouchData[1] = (nX >> 8) & 0xff;
	arTouchData[2] = (nX)& 0xff;
	arTouchData[3] = (nY >> 8) & 0xff;
	arTouchData[4] = (nY)& 0xff;
	SendTouchEvent(DEV_INPUT_TOUCHLCD, arTouchData);
}

void click(int nX, int nY)
{
	cout << "mouseClick at: (" << nX << "," << nY << ")" << endl;
	mouseDown(nX, nY);
	mouseUp(nX, nY);
}

void drag(int startX, int startY, int endX, int endY)
{
	cout << "DragDrop from: (" << startX << "," << startY << ") to (" << endX << "," << endY << ")" << endl;
	mouseDown(startX, startY);
	int num = 30;
	int diffX = (endX - startX) / num;
	int diffY = (endY - startY) / num;
	for (int i = 1; i < num; i++)
	{
		mouseDown(startX + diffX*i, startY + diffY * i);
		usleep(15000);
	}
	mouseUp(endX, endY);
}

class command
{
public:
	int type;
	int p[4];

	command()
	{
		type = 0;
	}
};

#define ACTION_MOUSE_CLICK 1
#define ACTION_MOUSE_DRAG 2
#define ACTION_SLEEP 3

void readCommandFromFile(char* fileName, vector<command> &commandList)
{
	ifstream fi(fileName);
	if (!fi)
	{
		return;
	}
	while (!fi.eof())
	{
		string line;
		getline(fi, line);
		if (line != "")
		{
			std::istringstream iss(line);
			string firstWord;
			iss >> firstWord;
			command newCommand;
			if (firstWord == "drag")
			{
				newCommand.type = ACTION_MOUSE_DRAG;

				iss >> firstWord;
				if (firstWord == "") continue;
				newCommand.p[0] = atoi(firstWord.c_str());

				iss >> firstWord;
				if (firstWord == "") continue;
				newCommand.p[1] = atoi(firstWord.c_str());

				iss >> firstWord;
				if (firstWord == "") continue;
				newCommand.p[2] = atoi(firstWord.c_str());

				iss >> firstWord;
				if (firstWord == "") continue;
				newCommand.p[3] = atoi(firstWord.c_str());

				commandList.push_back(newCommand);
			}
			else if (firstWord == "click")
			{
				newCommand.type = ACTION_MOUSE_CLICK;

				iss >> firstWord;
				if (firstWord == "") continue;
				newCommand.p[0] = atoi(firstWord.c_str());

				iss >> firstWord;
				if (firstWord == "") continue;
				newCommand.p[1] = atoi(firstWord.c_str());

				commandList.push_back(newCommand);
			}
			else if (firstWord == "sleep")
			{
				newCommand.type = ACTION_SLEEP;

				iss >> firstWord;
				if (firstWord == "") continue;
				newCommand.p[0] = atoi(firstWord.c_str());

				commandList.push_back(newCommand);
			}
			//cout << "command.type = " << newCommand.type << endl;
		}
	}
	fi.close();
}

int main(int argc, char* argv[])
{
	if (argc < 2)
	{
		cerr << "Usage: autotest command_file" << endl;
		return 2;
	}
	if (strcmp(argv[1], "click") == 0) {

		cout << "Day la click\n";
		int x = atoi(argv[2]);
		int y = atoi(argv[3]);
		click(x, y);
	}
	else if (strcmp(argv[1], "drag") == 0)
	{
		cout << "Day la drag";
		int x1 = atoi(argv[2]);
		int y1 = atoi(argv[3]);
		int x2 = atoi(argv[4]);
		int y2 = atoi(argv[5]);
		drag(x1, y1, x2, y2);
	}
	else if (strcmp(argv[1], "lpress") == 0)
	{
		int x1 = atoi(argv[2]);
		int y1 = atoi(argv[3]);
		int delaytime = atoi(argv[4]);


		mouseDown(x1, y1);
		usleep(delaytime * 1000);
		mouseUp(x1, y1);


	}
	else if (strcmp(argv[1], "press") == 0)
	{
		int x1 = atoi(argv[2]);
		int y1 = atoi(argv[3]);
		mouseDown(x1, y1);		
	}
	else if (strcmp(argv[1], "release") == 0)
	{
		int x1 = atoi(argv[2]);
		int y1 = atoi(argv[3]);
		mouseUp(x1, y1);
	}

	return 0;
}

