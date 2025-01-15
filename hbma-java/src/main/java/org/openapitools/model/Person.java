package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.model.Device;
import org.openapitools.model.VirtualProfile;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Person
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-15T13:08:41.429319800+01:00[Europe/Madrid]", comments = "Generator version: 7.10.0")
public class Person {

  private String id;

  private String name;

  private Device device;

  private VirtualProfile virtualProfile;

  public Person id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Person name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */
  
  @Schema(name = "name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Person device(Device device) {
    this.device = device;
    return this;
  }

  /**
   * Get device
   * @return device
   */
  @Valid 
  @Schema(name = "device", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("device")
  public Device getDevice() {
    return device;
  }

  public void setDevice(Device device) {
    this.device = device;
  }

  public Person virtualProfile(VirtualProfile virtualProfile) {
    this.virtualProfile = virtualProfile;
    return this;
  }

  /**
   * Get virtualProfile
   * @return virtualProfile
   */
  @Valid 
  @Schema(name = "virtualProfile", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("virtualProfile")
  public VirtualProfile getVirtualProfile() {
    return virtualProfile;
  }

  public void setVirtualProfile(VirtualProfile virtualProfile) {
    this.virtualProfile = virtualProfile;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Person person = (Person) o;
    return Objects.equals(this.id, person.id) &&
        Objects.equals(this.name, person.name) &&
        Objects.equals(this.device, person.device) &&
        Objects.equals(this.virtualProfile, person.virtualProfile);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, device, virtualProfile);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Person {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    device: ").append(toIndentedString(device)).append("\n");
    sb.append("    virtualProfile: ").append(toIndentedString(virtualProfile)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

