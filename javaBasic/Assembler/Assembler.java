interface PCI
{
public abstract void start();
void stop();
}
class NetworkCard implements PCI
{
	public void start()
	{
		System.out.println("networkcard start");
		}
		public void stop()
	{
		System.out.println("networkcard stop");
		}
	}
	class SoundCard implements PCI
{
	public void start()
	{
		System.out.println("di....di....");
		}
		public void stop()
	{
		System.out.println("soundcard stop");
		}
	}
	class MainBoard
	{
		/*public void useNetworkCard(NetworkCard nc)
		{
			nc.start();
			nc.stop();
			}
			*/
	
		public void usePCI(PCI p)
		{
			p.start();
			p.stop();
			}
		}
		public class Assembler
		{
			public static void main(String[] args)
			{
			MainBoard mb=new MainBoard();
			NetworkCard nc=new NetworkCard();
			SoundCard sc=new SoundCard();
			
			mb.usePCI(nc);
			mb.usePCI(sc);
			}
		}