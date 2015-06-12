package yh.tdd.fan.main.ModelA.api;

public class FakeModelAApi extends ModelAApi {
	private boolean isRunning = false;
	private boolean isRotating = false;
	private WindSpeed speed;

	@Override
	public void turnOn() {
		this.isRunning = true;
		System.out.println("turnOn");
		setSpeed(WindSpeed.LEVEL0);
	}

	@Override
	public void turnOff() {
		this.isRunning = false;
		System.out.println("turnOff");
	}

	@Override
	public void setSpeed(WindSpeed speed) {
		System.out.println("선풍기세기를 " + speed + "로 변경");
		this.speed = speed;
	}

	@Override
	public void startRotation() {
		this.isRotating = true;
		System.out.println("회전시작!");

	}

	@Override
	public void stopRotation() {
		this.isRotating = false;
		System.out.println("회전멈춤!");
	}

	@Override
	public boolean getPowerStatus() {
		return isRunning;
	}

	@Override
	public WindSpeed getSpeedButtonStatus() {
		return speed;
	}

	@Override
	public boolean getRotationButtonStatus() {
		return isRotating;
	}

	@Override
	public void setTimeout(float minute) {
		System.out.println("선풍기를 " + Float.valueOf(minute * 60).intValue() + "초후에 멈춘다..");

		try {
			Thread.sleep(Float.valueOf(minute * 60 * 1000).longValue());
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("타이머시간 " + Float.valueOf(minute * 60).intValue() + "초 종료!");
		this.turnOff();
	}
}
