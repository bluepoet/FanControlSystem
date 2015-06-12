package yh.tdd.fan.main.ModelA.control;

import yh.tdd.fan.main.ModelA.api.ModelAApi;
import yh.tdd.fan.main.control.FanTimeController;

public class ModelAFanTimeController implements FanTimeController {
	private ModelAApi api;

	public ModelAFanTimeController(ModelAApi api) {
		this.api = api;
	}

	@Override
	public void setTimeout(float minute) {
		api.setTimeout(minute);
	}

}
