package org.lion.swt.async.handler;

import org.eclipse.swt.widgets.Display;

public class Handler {
	
	private Display display = Display.getCurrent();
	
	private void execute( final Message msg ){
		display.asyncExec( new Runnable() {
			
			public void run() {
				handMessage(msg);
			}
		});
	}
	
	public void handMessage( Message msg ){
		//TODO
		System.out.println( msg.id );
	}
	
	public void sendMsg( Message msg ){
		this.execute(msg);
	}
	
	public void sendEmptyMsg( int id ){
		Message msg = new Message();
		msg.id = id;
		this.execute(msg);
	}
}
