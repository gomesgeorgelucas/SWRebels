package org.george.domain;

import lombok.*;

import org.george.enums.RaceEnum;

@Value
public class Rebel {
    String name;
    int age;
    RaceEnum race;
}
