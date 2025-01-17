package ru.product.star.logback1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.context.ApplicationContext;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ExtendWith(OutputCaptureExtension.class) // Добавьте эту аннотацию
class Logback1ApplicationTests {

	@Autowired
	private ApplicationContext context;

	@Test
	void contextLoads() {
		// Проверка, что контекст Spring Boot успешно загружается
		assertThat(context).isNotNull();
	}

	@Test
	void testDebugLogging(CapturedOutput output) {
		// Запуск приложения и проверка, что debug-сообщение записано в лог
		Logback1Application.main(new String[]{});
		assertTrue(output.getOut().contains("This is a debug message"));
	}

	@Test
	void testInfoLogging(CapturedOutput output) {
		// Запуск приложения и проверка, что info-сообщение записано в лог
		Logback1Application.main(new String[]{});
		assertTrue(output.getOut().contains("This is an info message"));
	}

	@Test
	void testInfoLogFile() throws Exception {
		// Проверка, что info-сообщение записано в файл info.log
		Logback1Application.main(new String[]{});
		String infoLogContent = Files.readString(Paths.get("logs/info.log"));
		assertTrue(infoLogContent.contains("This is an info message"));
	}

	@Test
	void testDebugLogFile() throws Exception {
		// Проверка, что debug-сообщение записано в файл debug.log
		Logback1Application.main(new String[]{});
		String debugLogContent = Files.readString(Paths.get("logs/debug.log"));
		assertTrue(debugLogContent.contains("This is a debug message"));
	}
}