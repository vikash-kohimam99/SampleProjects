package com.example.demo.filters;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	
	
	@GetMapping("/filtering")
	public FilteringBean gettingBean() {		
		return new FilteringBean("Value1", "value2", "value3");		
		
	}
	
	@GetMapping("/filtering-list")
	public List<FilteringBean> gettingListBean() {		
		return Arrays.asList(new FilteringBean("value4", "value6", "value7"),
				new FilteringBean("value14", "value6w", "value67"));	
		
	}

}
