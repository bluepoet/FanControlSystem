package yh.tdd.fan.main.control;

import yh.tdd.fan.main.ModelA.api.ModelAApi.WindSpeed;

public abstract class FanUI {
	public abstract boolean isRunning();
	
	public WindSpeed getWindStrength() {
		return WindSpeed.LEVEL0;
	}
	
	public boolean isRotating() {
		return false;
	}
}
