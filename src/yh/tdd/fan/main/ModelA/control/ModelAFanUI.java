package yh.tdd.fan.main.ModelA.control;

import yh.tdd.fan.main.ModelA.api.ModelAApi;
import yh.tdd.fan.main.ModelA.api.Pollable;
import yh.tdd.fan.main.ModelA.api.ModelAApi.WindSpeed;
import yh.tdd.fan.main.control.FanUI;

public class ModelAFanUI extends FanUI implements Pollable {
	private ModelAApi api;

	public ModelAFanUI(ModelAApi api) {
		this.api = api;
	}

	public boolean isRunning() {
		return api.getPowerStatus();
	}

	@Override
	public WindSpeed getWindStrength() {
		return api.getSpeedButtonStatus();
	}

	@Override
	public boolean isRotating() {
		return api.getRotationButtonStatus();
	}

	@Override
	public void poll() {
		if (api.getPowerStatus()) {
			System.out.println("선풍기 작동중");
			System.out.println("선풍기세기는 현재 " + api.getSpeedButtonStatus() + " 입니다.");
			System.out.println("선풍기는 현재 " + (api.getRotationButtonStatus() == true ? "회전중인" : "회전중이 아닌") + " 상태입니다.");
		} else {
			System.out.println("선풍기 멈춤");
		}

	}
}
