package yh.tdd.fan.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import yh.tdd.fan.main.ModelA.api.ModelAApi;
import yh.tdd.fan.main.ModelA.api.ModelAApi.WindSpeed;
import yh.tdd.fan.main.ModelA.control.ModelAFanTimeController;
import yh.tdd.fan.main.ModelA.control.ModelAFanUI;
import yh.tdd.fan.main.ModelA.control.ModelAFanWindDirectionRotator;
import yh.tdd.fan.main.ModelA.control.ModelAFanWindGenerator;
import yh.tdd.fan.main.ModelA.control.ModelAFanWindStrengthController;
import yh.tdd.fan.main.control.FanTimeController;
import yh.tdd.fan.main.control.FanWindDirectionRotator;
import yh.tdd.fan.main.control.FanWindGenerator;
import yh.tdd.fan.main.control.FanWindStrengthController;
import yh.tdd.fan.main.control.Pollable;

import com.google.common.collect.Lists;

@FixMethodOrder(MethodSorters.JVM)
public class FanControlSystemTest {
	private ModelAApi api;
	private FanWindGenerator fanWindGenerator;
	private ModelAFanUI ui;
	private List<Pollable> pollables = Lists.newArrayList();

	@Before
	public void setUp() {
		api = ModelAApi.instance();
		fanWindGenerator = new ModelAFanWindGenerator(api);
		ui = new ModelAFanUI(api);
		pollables.add(ui);
	}

	@Test
	public void generateAndPauseWind() throws Exception {
		// When
		System.out.println("=============== generateAndPauseWind ===============");
		fanWindGenerator.generate();

		// Then
		monitorUI(pollables);
		assertTrue(ui.isRunning());

		// When
		fanWindGenerator.pause();

		// Then
		monitorUI(pollables);
		assertFalse(ui.isRunning());
	}

	@Test
	public void controlWindSpeed() throws Exception {
		// Given
		System.out.println("=============== controlWindSpeed ===============");
		FanWindStrengthController fanWindStrengthController = new ModelAFanWindStrengthController(api);

		// When
		fanWindGenerator.generate();
		fanWindStrengthController.up();

		// Then
		assertSame(WindSpeed.LEVEL1, ui.getWindStrength());
		monitorUI(pollables);

		// When
		fanWindStrengthController.down();

		// Then
		assertSame(WindSpeed.LEVEL0, ui.getWindStrength());
		monitorUI(pollables);
	}

	@Test
	public void rotateWindDirection() throws Exception {
		// Given
		System.out.println("=============== rotateWindDirection ===============");
		FanWindDirectionRotator fanWindDirectionRotator = new ModelAFanWindDirectionRotator(api);

		// When
		fanWindGenerator.generate();
		fanWindDirectionRotator.rotate();

		// Then
		assertTrue(ui.isRotating());
		monitorUI(pollables);

		// When
		fanWindDirectionRotator.pause();

		// Then
		assertFalse(ui.isRotating());
		monitorUI(pollables);
	}

	@Test(timeout = 3500)
	public void pauseFanByTimer() throws Exception {
		// Given
		System.out.println("=============== pauseFanByTimer ===============");
		FanTimeController fanTimerController = new ModelAFanTimeController(api);

		// When
		fanWindGenerator.generate();
		fanTimerController.setTimeout(0.05f);

		// Then
		assertFalse(ui.isRunning());
		monitorUI(pollables);
	}

	private void monitorUI(List<Pollable> pollables) {
		for (Pollable pollable : pollables) {
			pollable.poll();
		}
	}
}
