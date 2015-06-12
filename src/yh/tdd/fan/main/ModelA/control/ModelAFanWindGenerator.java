package yh.tdd.fan.main.ModelA.control;

import yh.tdd.fan.main.ModelA.api.FakeModelAApi;
import yh.tdd.fan.main.ModelA.api.ModelAApi;
import yh.tdd.fan.main.ModelA.api.ModelAApi.WindSpeed;
import yh.tdd.fan.main.control.FanWindGenerator;

public class ModelAFanWindGenerator implements FanWindGenerator {
	private ModelAApi api;
	
	public ModelAFanWindGenerator(ModelAApi api) {
		this.api = api;
	}

	public static ModelAApi instance() {
		return new FakeModelAApi();
	}

	@Override
	public void generate() {
		api.isRunning = true;
		api.turnOn();
		api.setSpeed(WindSpeed.LEVEL0);
	}

	@Override
	public void pause() {
		api.isRunning = false;
		api.turnOff();
	}
}
