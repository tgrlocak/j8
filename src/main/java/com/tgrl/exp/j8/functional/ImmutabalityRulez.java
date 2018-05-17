package com.tgrl.exp.j8.functional;

import java.util.Collections;
import java.util.List;

import com.tgrl.exp.j8.model.Person;

/**
 * In functional programming, state is considered harmful and avoided whenever possible. Instead,
 * immutable (unchangeable) data structures are preferred.
 * 
 * <p>
 * As you may have learned, Java 8’s new Date-Time classes are immutable. What you may not have
 * realized is that almost everything added in Java 8 is immutable (<code>Optional</code> and
 * <code>Streams</code> for example).
 * </p>
 * 
 * @author tugrul.ocak
 *
 */
public class ImmutabalityRulez {

  public void avoidingNotToFallBackMutability() {
    List<Person> persons = Person.getPersons(); 
    
    int[] myCount = new int[1];
    persons.forEach(person -> {
      if(person.isMale()) myCount[0]++;
    });
    
    // The below phrase should be used instead of above count code
    persons.stream().filter(Person::isMale).count();
  }
}
