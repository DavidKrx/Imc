package dad.javafx.imc;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class IMC {
	private DoubleProperty altura = new SimpleDoubleProperty();
	private DoubleProperty peso = new SimpleDoubleProperty();
	private DoubleProperty imc = new SimpleDoubleProperty();
	private StringProperty imcliteral= new SimpleStringProperty();
	
	public final DoubleProperty alturaProperty() {
		return altura;
	}
	
	public final double getAltura() {
		return this.alturaProperty().get();
	}
	
	public final void setAltura(final double altura) {
		this.alturaProperty().set(altura);
		CalcularImc();
	}
	
	public final DoubleProperty pesoProperty() {
		return peso;
	}
	
	public final double getPeso() {
		return this.pesoProperty().get();
	}
	
	public final void setPeso(final double peso) {
		this.pesoProperty().set(peso);
		CalcularImc();
	}
	
	public final DoubleProperty imcProperty() {
		return imc;
	}
	
	public final double getImc() {
		return this.imcProperty().get();
	}
	
	public final void CalcularImc() {
		imcProperty().set(0);
		double imc=Math.round((getPeso()/(Math.pow(getAltura()/100, 2)))*100)/100.0;
		
		if (imc < 18.5)
			imcliteral.set("Bajo Peso");
		else if (imc >= 18.5 && imc < 25)
			imcliteral.set("Normal");
		else if (imc >= 25 && imc < 30)
			imcliteral.set("Sobrepeso");
		else if (imc > 30)
			imcliteral.set("Obeso");
		else
			imcliteral.set("");
		imcProperty().set(imc);
	}

	public final StringProperty imcliteralProperty() {
		return this.imcliteral;
	}
	

	public final String getImcliteral() {
		return this.imcliteralProperty().get();
	}
	

	public final void setImcliteral(final String imcliteral) {
		this.imcliteralProperty().set(imcliteral);
	}
	

	
}