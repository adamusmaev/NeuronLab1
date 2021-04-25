import lombok.Data;
import lombok.extern.log4j.Log4j;

@Data
@Log4j
public class Synapse {

    private Neuron inputNeron;
    private Neuron outputNeuron;
    private Double synapseWeight;
}
