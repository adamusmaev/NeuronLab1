import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Network network = new Network();

        Level level1 = new Level();
        List<Neuron> list1 = new ArrayList<>();
        level1.setNeuronList(list1);
        network.getLevelList().add(level1);
        for (int i = 0; i < 5; i++) {
            list1.add(new Neuron("Level1; " + i));
        }
        level1.getNeuronList().get(0).setFunctionValue(0.980);
        level1.getNeuronList().get(1).setFunctionValue(0.977);
        level1.getNeuronList().get(2).setFunctionValue(0.941);
        level1.getNeuronList().get(3).setFunctionValue(0.090);
        level1.getNeuronList().get(4).setFunctionValue(0.1);

        Level level2 = new Level();
        List<Neuron> list2 = new ArrayList<>();
        level2.setNeuronList(list2);
        network.getLevelList().add(level2);
        for (int i = 0; i < 4; i++) {
            list2.add(new Neuron("Level2; " + i));
        }

        Level level3 = new Level();
        List<Neuron> list3 = new ArrayList<>();
        level3.setNeuronList(list3);
        network.getLevelList().add(level3);
        for (int i = 0; i < 1; i++) {
            list3.add(new Neuron("Level3; " + i));
        }

        network.addRandomWeightForSynapse();

        for (int i = 0; i <1; i++) {
            level1.getNeuronList().get(0).setFunctionValue(0.980);
            level1.getNeuronList().get(1).setFunctionValue(0.977);
            level1.getNeuronList().get(2).setFunctionValue(0.941);
            level1.getNeuronList().get(3).setFunctionValue(0.090);
            level1.getNeuronList().get(4).setFunctionValue(0.1);
            network.sumValue();
            network.backPropagation(0.9);

            level1.getNeuronList().get(0).setFunctionValue(0.05);
            level1.getNeuronList().get(1).setFunctionValue(0.02);
            level1.getNeuronList().get(2).setFunctionValue(0.058);
            level1.getNeuronList().get(3).setFunctionValue(0.93);
            level1.getNeuronList().get(4).setFunctionValue(1.0);
            network.sumValue();
            network.backPropagation(0.1);

            level1.getNeuronList().get(0).setFunctionValue(0.27);
            level1.getNeuronList().get(1).setFunctionValue(0.36);
            level1.getNeuronList().get(2).setFunctionValue(0.41);
            level1.getNeuronList().get(3).setFunctionValue(0.5);
            level1.getNeuronList().get(4).setFunctionValue(1.0);
            network.sumValue();
            network.backPropagation(0.66);


            level1.getNeuronList().get(0).setFunctionValue(0.99);
            level1.getNeuronList().get(1).setFunctionValue(0.99);
            level1.getNeuronList().get(2).setFunctionValue(0.99);
            level1.getNeuronList().get(3).setFunctionValue(0.001);
            level1.getNeuronList().get(4).setFunctionValue(0.1);
            network.sumValue();
            network.backPropagation(1.0);

        }
        level1.getNeuronList().get(0).setFunctionValue(0.27);
        level1.getNeuronList().get(1).setFunctionValue(0.36);
        level1.getNeuronList().get(2).setFunctionValue(0.41);
        level1.getNeuronList().get(3).setFunctionValue(0.5);
        level1.getNeuronList().get(4).setFunctionValue(1.0);
        network.sumValue();
        network.backPropagation(0.66);

        for (int i = 0; i < network.getLevelList().size(); i++) {
            System.out.println(network.getLevelList().get(i));
        }
    }

}
