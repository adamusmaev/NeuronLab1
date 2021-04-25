import lombok.Data;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@Log4j
public class Network {

    private List<Synapse> synapseList = new ArrayList<>();
    private List<Level> levelList = new ArrayList<>();

    public void addRandomWeightForSynapse(){
        Random r = new Random();
        for (int i = 0; i < levelList.get(0).getNeuronList().size(); i++){
            for (int j = 0; j < levelList.get(1).getNeuronList().size(); j++){
                Synapse synapse = new Synapse();
                synapse.setInputNeron(levelList.get(0).getNeuronList().get(i));
                synapse.setOutputNeuron(levelList.get(1).getNeuronList().get(j));
                synapse.setSynapseWeight((r.nextDouble() - 0.5));
                synapseList.add(synapse);
            }
        }

        for(int i = 0; i < levelList.get(1).getNeuronList().size(); i++){

            Synapse synapse = new Synapse();
            synapse.setInputNeron(levelList.get(1).getNeuronList().get(i));
            synapse.setOutputNeuron(levelList.get(2).getNeuronList().get(0));
            synapse.setSynapseWeight((r.nextDouble() - 0.5));
            synapseList.add(synapse);
        }
    }

    public void sumValue(){
        for (int i = 0; i < synapseList.size(); i++){
            Neuron nInput = synapseList.get(i).getInputNeron();
            Neuron nOutput = synapseList.get(i).getOutputNeuron();
            nOutput.sumSynapseWeightFunction(nInput.getFunctionValue()*synapseList.get(i).getSynapseWeight());
        }
    }

    public void backPropagation(Double actualValue){
        Double mistakeValue = actualValue- levelList.get(2).getNeuronList().get(0).getFunctionValue();
        levelList.get(2).getNeuronList().get(0).setMistakeValue(mistakeValue);

        for (int i = 0; i < levelList.get(1).getNeuronList().size(); i ++){
            Neuron nInput = levelList.get(1).getNeuronList().get(i);
            Neuron nOutput = levelList.get(2).getNeuronList().get(0);
            levelList.get(1).getNeuronList().get(i).setMistakeValue(mistakeValue * findSynapse(nInput, nOutput).getSynapseWeight());
        }

        for (int i = 0; i < levelList.get(0).getNeuronList().size(); i++){
            Neuron nInput = levelList.get(0).getNeuronList().get(i);
            for (int j = 0; j < levelList.get(1).getNeuronList().size(); j++){
                Neuron nOutput = levelList.get(1).getNeuronList().get(j);
                Synapse synapse = findSynapse(nInput, nOutput);
                Double newValue = synapse.getSynapseWeight() + 0.1*nOutput.getMistakeValue() * 1/(1+Math.pow(Math.E, -nOutput.getSumSynapseWeight()))
                        *(1 - 1/(1+Math.pow(Math.E, -nOutput.getSumSynapseWeight()))) * nInput.getFunctionValue();
                synapse.setSynapseWeight(newValue);
            }
        }
        Neuron nOutput = levelList.get(2).getNeuronList().get(0);
        for (int i = 0; i < levelList.get(1).getNeuronList().size(); i++){
            Neuron nInput = levelList.get(1).getNeuronList().get(i);
            Synapse synapse = findSynapse(nInput, nOutput);
            Double newValue = synapse.getSynapseWeight() + 0.01*nOutput.getMistakeValue() * 1/(1+Math.pow(Math.E, -nOutput.getSumSynapseWeight()))
                    *(1 - 1/(1+Math.pow(Math.E, -nOutput.getSumSynapseWeight()))) * nInput.getFunctionValue();
            synapse.setSynapseWeight(newValue);
        }
    }

    public Synapse findSynapse(Neuron nInput, Neuron nOutput){
        for (int i = 0; i < synapseList.size(); i++){
            if (synapseList.get(i).getInputNeron().equals(nInput) && synapseList.get(i).getOutputNeuron().equals(nOutput)) return synapseList.get(i);
        }
        return null;
    }
}
