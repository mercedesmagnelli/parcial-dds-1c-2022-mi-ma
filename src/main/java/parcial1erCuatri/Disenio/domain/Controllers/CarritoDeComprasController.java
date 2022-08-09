package parcial1erCuatri.Disenio.domain.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import parcial1erCuatri.Disenio.domain.Repositorios.RepoCarritos;

@RestController
@RequestMapping("/compra")
public class CarritoDeComprasController {
  @Autowired
  private RepoCarritos repoCarritos;


}
