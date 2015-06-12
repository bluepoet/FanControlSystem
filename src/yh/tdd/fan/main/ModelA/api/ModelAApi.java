package yh.tdd.fan.main.ModelA.api;

public abstract class ModelAApi {
	public boolean isRunning = false;
	public boolean isRotating = false;

	public static enum WindSpeed {
		LEVEL0, LEVEL1, LEVEL2, LEVEL3;

		public WindSpeed speedUp() {
			if (this == WindSpeed.LEVEL3) {
				return this;
			}

			switch (this) {
			case LEVEL0:
				return LEVEL1;
			case LEVEL1:
				return LEVEL2;
			case LEVEL2:
				return LEVEL3;
			default:
				return this;
			}
		}

		public WindSpeed speedDown() {
			if (this == WindSpeed.LEVEL0) {
				return this;
			}

			switch (this) {
			case LEVEL1:
				return LEVEL0;
			case LEVEL2:
				return LEVEL1;
			case LEVEL3:
				return LEVEL2;
			default:
				return this;
			}
		}
	};

	public abstract void setSpeed(WindSpeed speed);

	public abstract void turnOn();

	public abstract void turnOff();

	public abstract void startRotation();

	public abstract void stopRotation();

	public abstract boolean getPowerStatus();

	public abstract WindSpeed getSpeedButtonStatus();

	public abstract boolean getRotationButtonStatus();

	public abstract boolean isTimeout();

	public static ModelAApi instance() {
		return new FakeModelAApi();
	}
}
