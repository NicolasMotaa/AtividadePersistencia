import controller.RestauranteController;
import repository.RestauranteRepository;
import service.RestauranteService;
import view.RestauranteView;


public class Run {
    static void main(String[] args) {

        RestauranteRepository repo = new RestauranteRepository();
        RestauranteService service = new RestauranteService(repo);
        RestauranteView view = new RestauranteView();
        RestauranteController controller = new RestauranteController(service, view);

        controller.laco();
    }

}
