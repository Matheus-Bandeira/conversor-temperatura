package com.conversor.serivces;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.conversor.models.Temperatura;
import com.conversor.response.CelsiusResponse;
import com.conversor.response.FahrenheitResponse;

@Service
public class TemperaturaService {

	public Object converter(Temperatura temperaturaRequest) {
		if (temperaturaRequest.getCelsius() == 0.0) {
			return calcularGrauCelcius(temperaturaRequest.getFahrenheit());
		} else {
			return calcularGrausFahrenheit(temperaturaRequest.getCelsius());
		}

	}

	private Object calcularGrausFahrenheit(double celsius) {
		// F = C x 1,8 + 32.
		double f = (celsius * 1.8) + 32;
		var fahrenheitResponse = new FahrenheitResponse();
		fahrenheitResponse.setTemperaturaGrausFahrenheit(f);
		return fahrenheitResponse;
	}

	private Object calcularGrauCelcius(double fahrenheit) {
		double c = (fahrenheit - 32) / 1.8;
		var celsiusResponse = new CelsiusResponse();
		celsiusResponse.setTemperaturaGrausCelsius(c);
		return celsiusResponse;
	}

}
