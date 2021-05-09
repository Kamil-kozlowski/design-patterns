import javafx.scene.text.Text;

public class DecoratorApp {
    public static void main(String[] args) {
        final String text = "This is an html text";
        TextWriter decorators = new BoldTextWriterDecorator(
                new EmptyLineTextWriterDecorator(
                        new EmptyLineTextWriterDecorator(
                                new TextWriterImpl()
                        )
                )
        );
        decorators.write(text); // Expected: <b>This is an html text</b></br></br>
    }
}

interface TextWriter {
    void write(String s);
}

class TextWriterImpl implements TextWriter {

    @Override
    public void write(String s) {
        System.out.println(s);
    }
}

class TextWriterDecorator implements TextWriter {

    private final TextWriter textWriter;

    public TextWriterDecorator(TextWriter textWriter) {
        this.textWriter = textWriter;
    }

    @Override
    public void write(String s) {
        textWriter.write(s);
    }
}

class BoldTextWriterDecorator extends TextWriterDecorator {

    public BoldTextWriterDecorator(TextWriter textWriter) {
        super(textWriter);
    }

    @Override
    public void write(String s) {
        super.write("<b>" + s + "</b>");
    }
}

class EmptyLineTextWriterDecorator extends TextWriterDecorator {

    public EmptyLineTextWriterDecorator(TextWriter textWriter) {
        super(textWriter);
    }

    @Override
    public void write(String s) {
        super.write(s + "</br>");
    }
}


