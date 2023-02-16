variable "namespace" {
  description = "The project namespace to use for unique resource naming"
  default     = "EC2-TEST"
  type        = string
}

variable "region" {
  description = "AWS region"
  default     = "ap-southeast-1"
  type        = string
}