import lombok.Data;
import lombok.extern.log4j.Log4j;

import java.util.ArrayList;
import java.util.List;

@Data
@Log4j
public class Level {

    private List<Neuron> neuronList = new ArrayList<>();
}
