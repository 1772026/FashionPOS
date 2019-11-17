package fashionPOS.Controller;

public class HomeController {
    private LoginController loginController;

    public void setMainFormController(LoginController mainFormController) {
        this.loginController=loginController;
    }
}
