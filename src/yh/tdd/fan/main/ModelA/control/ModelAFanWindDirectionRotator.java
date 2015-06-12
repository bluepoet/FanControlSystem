package yh.tdd.fan.main.ModelA.control;

import yh.tdd.fan.main.ModelA.api.ModelAApi;
import yh.tdd.fan.main.control.FanWindDirectionRotator;

public class ModelAFanWindDirectionRotator implements FanWindDirectionRotator {
	private ModelAApi api;

	public ModelAFanWindDirectionRotator(ModelAApi api) {
		this.api = api;
	}

	@Override
	public void rotate() {
		api.startRotation();
	}

	@Override
	public void pause() {
		api.stopRotation();
	}
}
