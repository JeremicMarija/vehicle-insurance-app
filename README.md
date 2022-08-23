This application is built in Clojure, the html template is built in Mustache. For Clojure it was used Clostache. For the web app library it was used Ring, Compojure is used to route the library for Ring. The database is MySQL.

The application enables the entry of data on material damages that occurred on the insured vehicle. 
The application keeps records of insured persons, their vehicles and material damages that occurred on those vehicles.
For each insured, the system enabled the creation, updating of each insureds from the records.
For each vehicle, the system made it possible to create, updating for vehicles from the records.
For each material damage, the system enabled the creation, updating of damage from the records, as well as the creation of material damage items.

Entering and changing information about the insured can be done independently of the vehicle and material damage. Entering data about the vehicle can be done after entering data about the insured if the insured does not exist in the system. Entering data on material damage to the vehicle can be done after entering data on the vehicle if the vehicle is not in the system. It is possible to enter data on items of material damage after entering data on damage if the material damage is not in the system.

To start a web server for the application, run:

    lein ring server

# vehicle-insurance-app

FIXME

## Prerequisites

You will need [Leiningen][] 2.0.0 or above installed.

[leiningen]: https://github.com/technomancy/leiningen

## Running



## License

Copyright © 2022 FIXME
