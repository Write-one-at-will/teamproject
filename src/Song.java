public class Song {
    private String name;
    private String singerName;
    private String region;
    private String kind;
    private String changeName;
    private String changeSingerName;
    public Song(){
        this.name="a name";
        this.singerName="a human";
        this.region="none";
    }
    public Song(String name,String singerName,String region,String kind){
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
    public void setKind(String kind){
        this.kind = kind;
    }

    public String getKind() {
        return kind;
    }

    public void setChangeName(String changeName) {
        this.changeName = changeName;
    }

    public String getChangeName() {
        return changeName;
    }

    public void setChangeSingerName(String changeSingerName) {
        this.changeSingerName = changeSingerName;
    }

    public String getChangeSingerName() {
        return changeSingerName;
    }

    public String toString(){
        return "Name -> " + name + "\n" + "   Singer's Name -> " + singerName + "\n" + "   Region -> " +
                region +"\n" + "   Kind -> " + kind + "\n";
    }

}