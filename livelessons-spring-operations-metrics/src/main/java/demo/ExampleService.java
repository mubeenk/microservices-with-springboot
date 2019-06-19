package demo;

import java.util.Random;

import org.springframework.stereotype.Service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Metrics;

@Service
public class ExampleService {

	private final Random random = new Random();

//	private final CounterService counterService;
//
//	private final GaugeService gaugeService;

	private final MeterRegistry service;
	
	public ExampleService(MeterRegistry counterService) {	//, GaugeService gaugeService) {
		this.service = counterService;
		//this.gaugeService = gaugeService;
	}

	public void call() {
		
		Counter featureCounter = Metrics.counter("feature");
		featureCounter.increment(this.random.nextDouble());
		//Gauage gauge = Metrics.gauge("example.gauge", this.random.nextDouble());

		
	}
}
