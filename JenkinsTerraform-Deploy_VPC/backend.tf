# --- root/backend.tf ---

terraform {
  backend "s3" {
    bucket     = "sf-remote-backend"
    key        = "remote.tfstate"
    region     = "ap-southeast-1"
  }
}
