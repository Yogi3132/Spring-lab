package org.cap.controller;

import java.util.List;

import org.cap.entities.Trainee;
import org.cap.exceptions.TraineeAlreadyExist;
import org.cap.exceptions.TraineeNotFound;
import org.cap.service.ITraineeService;
import org.cap.service.TraineeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TraineeController {

	@Autowired
	private ITraineeService traineeService;
	
	@GetMapping("/")
	public ModelAndView home(){
	    return new ModelAndView("LoginPage");
	}
	
	@GetMapping("logged")
	public ModelAndView operationspage(){
	    return new ModelAndView("allOperations");
	}
	
	@GetMapping("logging")
	public ModelAndView menu(@RequestParam("username") String username,@RequestParam("password") String password) {
		boolean result=traineeService.loginVerify(username, password);
		if(result==true)
		return new ModelAndView("allOperations");
		
		return new ModelAndView("LoginPage","msg","Wrong Username And Password");
	}
	@GetMapping("delete")
	public ModelAndView deletereach() {
		return new ModelAndView("deleteTrainee");
	}
	@GetMapping("getdelete")
	public ModelAndView delete(@RequestParam("tid") int traineeId) {
		Trainee trainee = traineeService.retrieveTrainee(traineeId);
		return new ModelAndView("deleteTrainee","trainee",trainee);
	}
	
	@GetMapping("deleting")
	public ModelAndView deleting(@RequestParam("traineeid") int traineeId) {
		Trainee trainee = traineeService.retrieveTrainee(traineeId);
		traineeService.deleteTrainee(trainee);
		return new ModelAndView("allOperations","delete","Deleted");
	}
	
	
	@GetMapping("modify")
	public ModelAndView updatereach() {
		return new ModelAndView("updatetrainee");
	}
	@GetMapping("getupdate")
	public ModelAndView update(@RequestParam("tid") int traineeId) {
		Trainee trainee = traineeService.retrieveTrainee(traineeId);
		return new ModelAndView("updateTrainee","trainee",trainee);
	}
	
	@GetMapping("updating")
	public ModelAndView updating(@RequestParam("traineeid") int traineeId,@RequestParam("traineeName") String traineeName,@RequestParam("traineeDomain") String traineeDomain,@RequestParam("traineeLocation") String traineeLocation) {
		Trainee trainee = new Trainee();
		trainee.setTraineeId(traineeId);
		trainee.setTraineeName(traineeName);
		trainee.setTraineeDomain(traineeDomain);
		trainee.setTraineeLocation(traineeLocation);
		traineeService.updateTrainee(trainee);
		return new ModelAndView("allOperations","update","Updated");
	}
	
	@GetMapping("retrieve")
	public ModelAndView find() {
		return new ModelAndView("findTrainee");
	}
	
	
	@GetMapping("registerhere")
	public ModelAndView registerPage() {
		return new ModelAndView("register");
	}
	
	@GetMapping("processregister")
	public ModelAndView processregister(@RequestParam("traineeid") int id,
										@RequestParam("traineename") String trname,
										@RequestParam("location") String location,
										@RequestParam("domain") String domain) {
		Trainee trainee= new Trainee();
		trainee.setTraineeId(id);
		trainee.setTraineeName(trname);
		trainee.setTraineeLocation(location);
		trainee.setTraineeDomain(domain);
		traineeService.addTrainee(trainee);
		return new ModelAndView("allOperations","register","Registered Successfully");
	}
	@GetMapping("findTraineeprocess")
	public ModelAndView retrieveTrainee(@RequestParam("tid") int id) {
		Trainee fetch=traineeService.retrieveTrainee(id);
		return new ModelAndView("findTrainee","trainee",fetch);
	}
	
	@GetMapping("retrieveall")
	public ModelAndView retrieveAllTrainee() {
		List<Trainee> fetchall=traineeService.retrieveAll();
		System.out.println(fetchall);
		return new ModelAndView("fetchAll","traineelist",fetchall);
	}
	
	
	
	
	@ExceptionHandler
	public ModelAndView handleException(TraineeNotFound exception) {
		String msg = exception.getMessage();
		return new ModelAndView("error","message",msg);
	}
	@ExceptionHandler
	public ModelAndView handleExcpet(TraineeAlreadyExist except) {
		String msg = except.getMessage();
		return new ModelAndView("error","message",msg);
	}
}
