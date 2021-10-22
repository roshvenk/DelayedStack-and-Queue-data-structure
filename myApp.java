interface ShowAd
{
    public void showAd(String s);
}

class App
{
    private String name;
    public App(String name)
    {
        this.name;

    }
    public int getName()
    {
        return name;
    }

}

class AndroidApp implements ShowAd extends App{
    public void AndroidApp()
    {
        super("Android App");
    }

    public showAd (String msg)
    {
        System.out.println(msg);
    }

}

class public MyApp
{
    public static void main(String [] params)
    {
        boolean paidVersion = true;
        App a = new AndroidApp();
        System.out.println(a.getName());
    }
    if(paidVersion)
    {
        a.showAd("Don't show Ad");
    }
}