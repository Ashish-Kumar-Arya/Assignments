package sdp;

public class SocketImplAdapter extends Socket implements SocketAdapter
{
	public Volt get120Volt() {
		return getVolt(); //calling the getVolt() of socket class and hence it returns Volt object of 120 volts
	}
	
	public Volt get12Volt() {
		Volt v=getVolt(); //calling the getVolt() of socket class and hence it returns Volt object of 120 volts
		return convert(v,10);
	}
	
	public Volt get3Volt() {
		Volt v=getVolt(); //calling the getVolt() of socket class and hence it returns Volt object of 120 volts
		return convert(v,40);
	}
	
	public Volt convert(Volt v, int i) {
		return new Volt(v.getVolts()/i);
	}
}
