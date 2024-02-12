package code.dp.behavioral.chainofresponsibility;

public abstract class Processor {

    private Processor nextProcessor;

    public Processor(Processor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public void process(Number request) {
        if (nextProcessor != null)
            nextProcessor.process(request);
    }

}
