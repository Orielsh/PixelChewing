class Pixel {

    private boolean isAlive;
    private boolean nextGen;
    Pixel (boolean state){
        isAlive = state;
    }

    boolean isAlive(){
        return  this.isAlive;
    }

    public void setNextGen(boolean next){
        this.nextGen = next;
    }

    public void evolve(){
        this.isAlive = this.nextGen;
        this.nextGen = false;
    }

    void flip() {
        this.isAlive = !(this.isAlive);
    }


}
