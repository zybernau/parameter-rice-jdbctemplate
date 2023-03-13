package in.zybernau.raja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/raja")
public class RajaController {

  @Autowired
  private RajaDao rajaDao;

  @RequestMapping(path="/delete")
  public String hello() {
    rajaDao.deleteTest();
    return "Hello Raja";
  }


}
