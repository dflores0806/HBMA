# MQTT-based HBMA running example

This example illustrates how the HBMA pattern can be instantiated using MQTT as a message-exchange mechanism.

The goal is to show the interaction between:

- a **controller**, which manages the environment;
- a **companion device**, which represents a person;
- a **virtual profile**, which contains the information and services that the person can selectively expose.

---

## Scenario

A controller detects a person in a smart environment. Once the person is detected, the controller requests the person’s virtual profile. The companion device receives the request and publishes the profile. The controller then processes the received profile and makes the available services accessible to authorized consumers.

---

## Topics

Suggested MQTT topics:

```text
hbma/controller/request-profile
hbma/person/J0123E/profile
hbma/person/J0123E/services
```

---

## Step 1. Start an MQTT broker

Using Docker:

```bash
docker run -it -p 1883:1883 eclipse-mosquitto
```

Or start a local Mosquitto broker:

```bash
mosquitto -p 1883
```

---

## Step 2. Controller requests a virtual profile

The controller publishes a request:

```bash
mosquitto_pub -h localhost -t hbma/controller/request-profile -m '{"personId":"J0123E","request":"virtualProfile"}'
```

---

## Step 3. Companion device publishes the profile

The companion device publishes the person’s virtual profile:

```bash
mosquitto_pub -h localhost -t hbma/person/J0123E/profile -f examples/virtual-profile-example.json
```

---

## Step 4. Controller subscribes to profile updates

The controller can listen for the profile:

```bash
mosquitto_sub -h localhost -t hbma/person/J0123E/profile
```

---

## Step 5. Profile processing

After receiving the profile, the controller can:

1. instantiate the person and device entities;
2. read the virtual profile;
3. apply access-control rules;
4. expose only the allowed services;
5. make the selected information available to other entities in the environment.

---

## Relation with HBMA

This example illustrates three core HBMA ideas:

- people are represented by companion devices;
- personal information is encapsulated in a virtual profile;
- selected information is exposed as services under access-control restrictions.

The example is intentionally simple and can be extended with persistence, authentication, richer privacy policies, and ontology-based processing.
