package io.demo.resttemplate;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.demo.utility.resttemplate.Utility;

@RestController
@RequestMapping("/api")
public class DetailsController{
	private static final Logger LOGGER = LoggerFactory.getLogger(DetailsController.class);
	
	@GetMapping("/hi")
	public ResponseEntity<String> getApiResponse(@RequestParam Optional<String> title) {
		LOGGER.info("DetailsCOntroller getApiResponse:started");
		try{
			String str=	"<html><body><h5 style='font-size:60px;background-color:DodgerBlue;'>Welcome to API !</h5></body></html>";
			return new ResponseEntity<>(str, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/numeral/{nmrs}")
	public ResponseEntity<String> getApiResponseNumeralToDgt(@PathVariable("nmrs") String nmrs) {
		try{
			int digit=Utility.getInput(nmrs);
			System.out.println("Numerals to Digit COnverted: "+digit);
			String str=	"<html><body><h5 style='font-size:60px;background-color:DodgerBlue;'>"+"Nemeral value="+nmrs+" , Converted into Digits value ="+Integer.toString(digit)+"</h5></body></html>";
			return new ResponseEntity<>(str, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/digit/{digit}")
	public ResponseEntity<String> getApiResponseDgtToNumeral(@PathVariable("digit") int digit) {
		String str=null;
		try{
			if(digit<=0){
				str=	"<html><body><h5 style='font-size:60px;background-color:silver;'>"+"Digit value: "+digit+" is invalid ,please provide valid input</h5></body></html>";
			}
			else{
				String numeralValue=Utility.intToRoman(digit);
				str=	"<html><body><h5 style='font-size:60px;background-color:DodgerBlue;'>"+"Digit value ="+digit+", Converted into numeral value = "+numeralValue+"</h5></body></html>";
			}
			return new ResponseEntity<>(str, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
