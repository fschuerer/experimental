package de.fs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author XLKAFR
 */
@Entity
public class Tagesplan {

    @Id
    @GeneratedValue
    long id;

}
