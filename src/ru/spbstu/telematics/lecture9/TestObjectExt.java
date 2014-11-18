package ru.spbstu.telematics.lecture9;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class TestObjectExt implements Externalizable {
	
	public String name = "test";

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.write(name.getBytes());
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		byte[] buf = new byte[in.available()];
		in.read(buf);
		name = new String(buf);
	}
	
}
