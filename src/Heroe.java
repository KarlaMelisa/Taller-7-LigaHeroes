public class Heroe {
    private int id;
    private String nombre;
    private String superpoder;
    private String mision;
    private int dificultad;
    private float sueldo;

    public Heroe(int id, String nombre, String superpoder, String mision, int dificultad, float sueldo) {
        this.id = id;
        this.nombre = nombre;
        this.superpoder = superpoder;
        this.mision = mision;
        this.dificultad = dificultad;
        this.sueldo = sueldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSuperpoder() {
        return superpoder;
    }

    public void setSuperpoder(String superpoder) {
        this.superpoder = superpoder;
    }

    public String getMision() {
        return mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public float calcularAporte(){
        return this.sueldo * 0.1f;
    }

    public float calcularImpuesto(){
        float pagoAnual=sueldo*12;
        float impuestoAnual;
        if(pagoAnual<=60000){
            impuestoAnual=0;
        } else if(pagoAnual<=120000){
            impuestoAnual=(pagoAnual-60000)*0.12f;
        }else if (pagoAnual<=240000){
            impuestoAnual=(pagoAnual-120000)*0.25f;
        } else {
            impuestoAnual=(pagoAnual-240000)*0.35f;
        }
        return impuestoAnual/12;
    }

    public float calcularSueldoNeto(){
        float aporte = calcularAporte();
        float impuesto = calcularImpuesto();
        return sueldo - aporte - impuesto;
    }


    @Override
    public String toString() {
        return  " ID: " + id +
                " Nombre: " + nombre + "\n" +
                " Superpoder principal: " + superpoder + "\n" +
                " Mision asignada: " + mision + "\n" +
                " Dificultad de la misión (1-5): " + dificultad + "\n" +
                " Sueldo mensual: " + sueldo;
    }
}
