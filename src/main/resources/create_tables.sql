create table RECIPE(
          ID long not null AUTO_INCREMENT,
          RECIPE_NAME varchar(100) not null,
          RECIPE_TYPE varchar(30),
          NO_OF_SERVINGS int,
          PRIMARY KEY (ID)
);

create table INGREDIENT(
           ID long not null AUTO_INCREMENT,
           INGREDIENT_NAME varchar(100) not null,
           RECIPE_ID long,
           foreign key (RECIPE_ID) references RECIPE(ID)
);

create table INSTRUCTION(
           ID long not null AUTO_INCREMENT,
           INSTRUCTION_NAME varchar(200) not null,
           RECIPE_ID long,
           foreign key (RECIPE_ID) references RECIPE(ID)
);
