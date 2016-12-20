package org.infinispan.commons.marshall.jboss;

import org.infinispan.commons.marshall.Externalizer;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class JBossExternalizerAdapter implements org.jboss.marshalling.Externalizer {
   private static final long serialVersionUID = 8187679200599686076L;

   final Externalizer<? super Object> externalizer;

   public JBossExternalizerAdapter(Externalizer<? super Object> externalizer) {
      this.externalizer = externalizer;
   }

   @Override
   public void writeExternal(Object subject, ObjectOutput output) throws IOException {
      externalizer.writeObject(output, subject);
   }

   @Override
   public Object createExternal(Class<?> targetClass, ObjectInput input) throws IOException, ClassNotFoundException {
      return externalizer.readObject(input);
   }
}