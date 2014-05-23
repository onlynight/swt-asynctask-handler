package org.lion.swt.async.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.lion.swt.async.handler.Handler;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

class MainWindow {

	protected Shell shell;
	
	private Handler handler;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		initHanlder();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Button btnSendmessage = new Button(shell, SWT.NONE);
		btnSendmessage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				new Thread( new Runnable() {
					
					public void run() {
						try {
							Thread.sleep( 1000 );
							handler.sendEmptyMsg( 123 );
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}).start();
			}
		});
		btnSendmessage.setBounds(176, 102, 114, 27);
		btnSendmessage.setText("SendMessage");
	}
	
	private void initHanlder(){
		handler = new Handler();
	}
}
