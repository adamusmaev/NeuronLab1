import lombok.Data;
import lombok.extern.log4j.Log4j;

@Data
@Log4j
public class Neuron {

    private String name;

    private Double functionValue = 0.0;

    private Double sumSynapseWeight = 0.0;

    private Double mistakeValue = 0.0;

    public Neuron(String name) {
        this.name = name;
    }


    public Neuron() {

    }

    public void sumSynapseWeightFunction(Double value) {
        sumSynapseWeight = sumSynapseWeight + value;
        functionValue = 1 / (1 + Math.pow(Math.E, -sumSynapseWeight));
    }
}
