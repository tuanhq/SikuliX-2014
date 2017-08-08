package org.sikuli.weston;

public class ExecuteOutput {
	private String output;
	private int exitStatus;

	public ExecuteOutput() {

	}

	public ExecuteOutput(String output, int exitStatus) {
		this.output = output;
		this.exitStatus = exitStatus;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public int getExitStatus() {
		return exitStatus;
	}

	public void setExitStatus(int exitStatus) {
		this.exitStatus = exitStatus;
	}

}
