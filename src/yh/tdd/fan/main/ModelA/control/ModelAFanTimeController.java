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
		System.out.println("선풍기를 " + Float.valueOf(minute * 60).intValue() + "초후에 멈춘다..");
		try {
			Thread.sleep(Float.valueOf(minute * 60 * 1000).longValue());
		} catch (Exception e) {
		}
		api.isRunning = false;
	}

}
