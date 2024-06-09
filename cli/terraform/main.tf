terraform {
  required_providers {
    azuredevops = {
      source = "microsoft/azuredevops"
      version = "1.1.1"
    }
  }
}

provider "azuredevops" {
  # Configuration options
}

data "azuredevops_project" "khost" {
  name = "Khost"
}

resource "azuredevops_build_definition" "khost_cli" {
  name = "Khost CLI"
  project_id = data.azuredevops_project.khost
  path = "\\Khost"
}
