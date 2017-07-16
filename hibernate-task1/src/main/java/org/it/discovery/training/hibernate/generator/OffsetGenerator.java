package org.it.discovery.training.hibernate.generator;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class OffsetGenerator implements IdentifierGenerator {
	
	private int offset = 100;

	@Override
	public Serializable generate(SharedSessionContractImplementor arg0, Object arg1) throws HibernateException {
		return offset++;
	}

}
