package de.fs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author XLKAFR
 */
@Entity
public class Wochenplan {

    @Id
    @GeneratedValue
    long id;
    String von;
    String bis;
}
