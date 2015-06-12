package yh.tdd.fan.main.ModelA.control;

import yh.tdd.fan.main.ModelA.api.ModelAApi;
import yh.tdd.fan.main.ModelA.api.ModelAApi.WindSpeed;
import yh.tdd.fan.main.control.FanWindStrengthController;

public class ModelAFanWindStrengthController implements FanWindStrengthController {
	private ModelAApi api;

	public ModelAFanWindStrengthController(ModelAApi api) {
		this.api = api;
	}

	@Override
	public void up() {
		WindSpeed speed = api.getSpeedButtonStatus();
		api.setSpeed(speed.speedUp());
	}

	@Override
	public void down() {
		WindSpeed speed = api.getSpeedButtonStatus();
		api.setSpeed(speed.speedDown());
	}
}
