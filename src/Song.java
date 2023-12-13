public class Song{
    private String name;
    private String singerName;
    private String region;

    public Kind kind;

    public Song(){
        this.name="a name";
        this.singerName="a human";
        this.region="none";
        this.kind = Kind.valueOf("none");
    }
    public Song(String name,String singerName,String region,Kind kind){
        this.name=name;
        this.singerName=singerName;
        this.region=region;
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    public void setKind(Kind kind){
        this.kind = kind;
    }

    public Kind getKind() {
        return this.kind;
    }

    public String toString(){
        return "Name -> " + name + "\n" + "   Singer's Name -> " + singerName + "\n" + "   Region -> " +
                region +"\n" + "   Kind -> " + kind + "\n";
    }

}